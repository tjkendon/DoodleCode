# Season Length Calculator

Calculator to look at how long sporting seasons need to be to determine a proper sorting of the teams.

## Overview

The basic point of the Season Length Calculator is to take a look at how many games a comptition needs to really confirm that the result shows the "True Strength" of the teams compeating. This is another programatic attempt to make fun of sports announcers (see [List Different Finder](https://github.com/tjkendon/DoodleCode/tree/main/ListDifferenceFinder)). In this case this is a response to the excited announcer talking about how great a team is doing, when they've won 3 games in a row, but they have no chance of actually making the play offs.

The system is designed to create seasons with a number of competators. Each team has a "True Strength" which indicates how strong the competator should be in competition (as a value from 0 - 1). This value is used to have competators compete head-to-head which are then compiled over the season. Experiments can then be run to determine what's necessary to have the records converge on the "True Strength". 

I'm also messing around with different models for competition (Round Robin, Repeated Competitions, Disjoint Competitions...) and different models for points (How many points for a win, tie, etc), which should let us see if the points or competition matter for usefulness.


