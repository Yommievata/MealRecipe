import React from 'react';

function MealList({ meals }) {
  return (
    <div>
      {meals && meals.length > 0 ? (
        <ul>
          {meals.map((meal) => (
            <li key={meal.idMeal}>
              <p>{meal.strMeal}</p>
              <p>{meal.idMeal}</p>
              <p>{meal.strInstructions}</p>
              <p>{meal.strDrinkAlternate}</p>
            </li>
          ))}
        </ul>
      ) : (
        <p>No meals found.</p>
      )}
    </div>
  );
}

export default MealList;
