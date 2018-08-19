Story: The Berlin Clock

Meta:
@scope interview

Narrative:
    As a clock enthusiast
    I want to tell the time using the Berlin Clock
    So that I can increase then number of ways that I can read the time
    
Scenario: The Yellow light should be on/off on every two seconds
When the second is 0 
Then the yellow light should look like
Y

Scenario: The First Hours Line 
Then the first hours line should have no of lines
4

Scenario: The first hours line's lights should be on after 5 hours
When the hours is 24
Then the first line hours should look like
RRRR

Scenario: The Second Hours Line 
Then the second hours line should have no of lights
4 

Scenario: The second hours line's lights should be on after every hour left from first hour line
When the second line hours is 13
Then the second line hours should look like
RRRO

Scenario: The First Minutes Line 
Then the first minutes line should have no of lights
11

Scenario: First Line Minutes should indicate first, second and last quarter
If the minutes is 32
Then the sequence will be RRO

Scenario: The First minute line should switch on a yellow light for every 5 minutes unless it is 1st/half/last quarter
If the first minute line is 17
Then the first minute line should look like this
YYROOOOOOOO

Scenario: The Second Minutes Line 
Then the Second minutes line should have no of lights
4

Scenario: The second minute line should switch on a yellow light left from first minute linw
If the second minute line is 17
Then the second minute line should look like this
YYOO

Scenario: Midnight
When the time is 00:00:00
Then the clock should look like
Y
OOOO
OOOO
OOOOOOOOOOO
OOOO

Scenario: Middle of the afternoon
When the time is 13:17:01
Then the clock should look like
O
RROO
RRRO
YYROOOOOOOO
YYOO

Scenario: Just before midnight
When the time is 23:59:59
Then the clock should look like
O
RRRR
RRRO
YYRYYRYYRYY
YYYY

Scenario: Midnight
When the time is 24:00:00
Then the clock should look like
Y
RRRR
RRRR
OOOOOOOOOOO
OOOO


