#!/bin/bash
set -u -e
javac Game.java View.java Controller.java Model.java Brick.java Json.java Link.java Sprite.java Boomerang.java Pot.java
java Game
