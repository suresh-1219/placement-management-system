import React, { useState, useEffect } from 'react';


const PlacementForm = ({ fetchPlacement, editingPlacement, setEditingPlacement }) => {
  const [id, setid] = useState('');
  const [name, setname] = useState('');
  const [date, setdate] = useState('');
  const [qualification, setqualification] = useState('');
  const [year, setyear] = useState('');


  useEffect(() => {
    if (editingPlacement) {
      setid(editingPlacement.id);
      setname(editingPlacement.name);
      setdate(editingPlacement.date);
      setqualification(editingPlacement.qualification);
      setyear(editingPlacement.year);
    }
  }, [editingPlacement]);


 
const handleSubmit = async (p) => {
  p.preventDefault();

  const placement = {
    id: Number(id),
    name,
    date,
    qualification,
    year: Number(year)
  };

  const url = editingPlacement
    ? `http://localhost:8080/placements/${id}`
    : 'http://localhost:8080/placements';

  const method = editingPlacement ? 'PUT' : 'POST';

  try {
    const response = await fetch(url, {
      method,
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(placement)
    });

    if (!response.ok) {
      const errorText = await response.text();
      throw new Error(errorText || `Request failed: ${response.status}`);
    }

    await fetchPlacement();

    // Clear fields only after successful save
    setEditingPlacement(null);
    setid('');
    setname('');
    setdate('');
    setqualification('');
    setyear('');

    alert('Placement saved successfully!');
  } catch (error) {
    console.error('Error saving placement:', error);
    alert('Failed to save placement. Please check the console.');
  }
};


  return (
    <div className="form-container">
      <h2>{editingPlacement ? 'Editing Data' : 'Adding Data'}</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          value={id}
          onChange={(p) => setid(p.target.value)}
          placeholder="ID"
          required
          disabled={editingPlacement}
        />
        <input
          type="text"
          value={name}
          onChange={(p) => setname(p.target.value)}
          placeholder="Name"
          required
          
          />

        <input
  type="date"
  value={date}
  onChange={(p) => setdate(p.target.value)}
  required
/>
          <input
          type="text"
          value={qualification}
          onChange={(p) => setqualification(p.target.value)}
          placeholder="Qualification"
          required
          
          />
        <input
          type="number"
          value={year}
          onChange={(p) => setyear(p.target.value)}
          placeholder="Year"
          required
        />
        <button type="submit">{editingPlacement ? 'UPDATE DATA' : 'ADD DATA'}</button>
      </form>
    </div>
  );
};


export default PlacementForm;
