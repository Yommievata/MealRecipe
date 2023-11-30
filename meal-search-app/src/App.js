import logo from './logo.svg';
import './App.css';

import React, { useState } from 'react';
import MealList from './MealList';

function App() {
  const [ingredient, setIngredient] = useState('');
  const [meals, setMeals] = useState(null);
  const [error, setError] = useState(null);

  const handleSearch = async () => {
    try {
      const response = await fetch(`http://localhost:8080/recipes/search?ingredient=${ingredient}`);

      if (!response.ok) {
        throw new Error('Network response was not ok');
      }

      const data = await response.json();
      console.log('API Response:', data);

      // Check if the data object has properties
      if (Object.keys(data).length > 0) {
        setMeals([data]); // Wrap the single meal in an array
        setError(null);
      } else {
        setMeals([]); // Set meals to an empty array
        setError('No meals found.');
      }
    } catch (error) {
      console.error('Error fetching data:', error);
      setError('Error fetching data. Please try again.');
    }
  };

  return (
    <div>
      <input type="text" value={ingredient} onChange={(e) => setIngredient(e.target.value)} />
      <button onClick={handleSearch}>Search</button>

      {error && <p style={{ color: 'red' }}>{error}</p>}

      {/* Render MealList only if meals is not null */}
      {meals !== null && <MealList meals={meals} />}
    </div>
  );
}

export default App;