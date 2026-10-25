import React, { useState, useEffect } from 'react';
import './App.css';
import PlacementForm from './Components/PlacementForm';
import PlacementList from './Components/PlacementList';

const App = () => {
  const [placement, setPlacement] = useState([]);
  const [editingPlacement, setEditingPlacement] = useState(null);

  useEffect(() => {
    fetchPlacements(); // Fetch placements on initial load
  }, []);

  const fetchPlacements = async () => {
    try {
const response = await fetch('http://localhost:8080/placements');      const data = await response.json();
      setPlacement(data);
    } catch (error) {
      console.error('Error fetching placement:', error);
    }
  };

  return (
    <div className="App">
      <h1>Placement Management</h1>
      <PlacementForm
        fetchPlacement={fetchPlacements} // Corrected to fetchPlacements
        editingPlacement={editingPlacement}
        setEditingPlacement={setEditingPlacement}
      />
      <PlacementList
        placement={placement}
        fetchPlacement={fetchPlacements} // Corrected to fetchPlacements
        setEditingPlacement={setEditingPlacement}
      />
    </div>
  );
};

export default App;
