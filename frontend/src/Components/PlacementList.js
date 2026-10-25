import React from 'react';

const PlacementList = ({ placement, fetchPlacement, setEditingPlacement }) => {
  
const handleDelete = async (id) => {
  try {
    const response = await fetch(
      `http://localhost:8080/placements/${id}`,
      { method: 'DELETE' }
    );

    if (!response.ok) {
      throw new Error(`Delete failed: ${response.status}`);
    }

    await fetchPlacement();
    alert('Placement deleted successfully!');
  } catch (error) {
    console.error('Error deleting placement:', error);
    alert('Failed to delete placement. Check the browser console.');
  }
};


  return (
    <div className="placement-list">
      <ul>
        {placement.map((placement) =>(
          <li key={placement.id} className="placement-item">
            <span>{placement.name}</span>
            <span>{placement.date}</span>  
            <span>{placement.qualification}</span>
            <span>{placement.year}</span>

            <button onClick={() => setEditingPlacement(placement)}>Edit</button>
            <button onClick={() => handleDelete(placement.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
};
export default PlacementList;

