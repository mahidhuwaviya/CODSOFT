<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title> Guess Master</title>
    <style>
        :root {
            --neon-green: #39ff14;
            --neon-blue: #00d2ff;
            --dark-bg: #0d0d0d;
        }

        body {
            background-color: var(--dark-bg);
            color: white;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }

        /* Top Bar for Points */
        .header-bar {
            position: absolute;
            top: 20px;
            width: 80%;
            display: flex;
            justify-content: space-between;
            padding: 15px 30px;
            background: rgba(255, 255, 255, 0.05);
            border: 1px solid var(--neon-blue);
            border-radius: 15px;
            box-shadow: 0 0 15px var(--neon-blue);
        }

        .score-box {
            font-size: 1.5rem;
            font-weight: bold;
            color: var(--neon-green);
        }

        /* Game Card */
        .game-container {
            background: rgba(255, 255, 255, 0.1);
            backdrop-filter: blur(10px);
            padding: 40px;
            border-radius: 20px;
            border: 1px solid rgba(255, 255, 255, 0.2);
            text-align: center;
            width: 400px;
        }

        h1 { text-shadow: 0 0 10px var(--neon-blue); }

        .input-group { margin: 20px 0; }

        input[type="number"], select {
            padding: 10px;
            border-radius: 5px;
            border: none;
            width: 80%;
            background: #222;
            color: white;
            border: 1px solid #444;
        }

        button {
            background: var(--neon-blue);
            color: black;
            border: none;
            padding: 12px 30px;
            font-weight: bold;
            border-radius: 5px;
            cursor: pointer;
            transition: 0.3s;
            text-transform: uppercase;
        }

        button:hover {
            box-shadow: 0 0 20px var(--neon-blue);
            transform: scale(1.05);
        }

        .message {
            margin-top: 20px;
            font-style: italic;
            color: var(--neon-green);
        }
    </style>
</head>
<body>
<%
String msg=(String)request.getAttribute("message");
Boolean isOver=(Boolean)request.getAttribute("gameOver");
Integer remaining= (Integer)request.getAttribute("remainingGuesses");
%>
    <div class="header-bar">
        <span>PLAYER</span>
        <div class="score-box">POINTS: ${points != null ? points : 0}</div>
    </div>

    <div class="game-container">
        <h1>GUESS THE NUMBER</h1>
        <p>Between 1 and 100</p>

        <form action="startGame" method="POST">
            
            <div class="input-group">
                <label>Difficulty (Max Guesses):</label><br>
                <select name="maxAttempts" ${remainingGuesses != null ? 'disabled' : ''}>
                    <option value="15"> 15 (at Ease)</option>
                    <option value="10">10 (Easy)</option>
                    <option value="5">5 (Medium)</option>
                    <option value="3">3 (Hardcore)</option>
                    
                </select>
            </div>

            <div class="input-group">
                <input type="number" name="userGuess" placeholder="Enter your guess..." required min="1" max="100">
            </div>

            <button type="submit">Deploy Guess</button>
        </form>
<%
if (msg!=null && !msg.isEmpty()){
%>
      
            <div class="message">
                SYSTEM:<%= msg %>> <br>
				<% if (remaining!=null){ %> 
                   Attempts Left: ${remainingGuesses}
                <%} %>
            </div>
     
<%} %>
<%
if (Boolean.TRUE.equals(isOver)){
%>            <form action="resetGame" method="POST" style="margin-top: 15px;">
                <button type="submit" style="background: var(--neon-green);">Restart Game</button>
            </form>
        <%} %>
    </div>

</body>
</html>