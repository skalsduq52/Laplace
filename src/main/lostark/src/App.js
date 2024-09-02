import React, { useState } from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';



function test(characterName) {
    const req = {
        character : characterName
    };

    fetch("http://127.0.0.1:8080/loa)",{
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(req),
    })
    console.log("req");
    console.log(JSON.stringify(req));
}

function App() {
    const [inputValue, setInputValue] = useState('');
    const handleClick = () => {
        test(inputValue)
    }
    const handleChange = (event) => {
        setInputValue(event.target.value);
    };


  return (
    <div className="App">
      <header className="top-header">
        <div className="container">
          <a className="logo-home" href="http://localhost:3000">민엽 군장검사</a>
          <input className="search-cha" placeholder="캐릭터 명을 입력하세요" value={inputValue} onChange={handleChange} onKeyPress={handleClick}></input>
            <button className="chbutton" onClick={handleClick} >ㅎㅇ</button>
        </div>
      </header>
      <nav className="top-nav">
        <div className="container">
          <ul className="navigation">
            <li>홈</li>
            <li>골드 정보</li>
            <li>임시</li>
            <li>임시2</li>
          </ul>
        </div>
      </nav>
    </div>
  );
}

export default App;
