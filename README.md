# Airline Passenger Priority List

An Airline Passenger Priority List implementation in Java utilizing Heaps, Stacks, Priority Queues, and LinkedLists.

## Description

- A fare code can be one of three values: Full, Disc, Buddy, and priority is given to passengers in this order. 
  - Create an enum for the fare code and include a method called `randomValue` that randomly chooses one of these values.

- A flyer status code can be one of four values: Gold, Silver, Bronze, None, and priority is given to passengers in this order. 
  - Create an enum for the fare code and include a method called `randomValue` that randomly chooses one of these values.

- Given two passengers, they are ordered first by the fare code in the order Full, Disc, Buddy. 
  - If two passengers have the same fare code, they are ordered by their flyer status in the order Gold, Silver, Bronze, None. 
  - If the fare codes and flyer statuses are the same, the first passenger (based on the timestamp) is ordered first.

- The simulation of the standby list should do the following:
  - Add 10 new passengers, whose passport numbers are provided by the user but the fare code and flyer status are randomly chosen.
  - Remove 5 passengers based on their priority.
  - Add 5 more passengers, whose passport numbers are provided by the user but the fare code and flyer status are randomly chosen.
  - Remove all passengers from the standby list based on their priority.

## Implementation Details

- Java will be the primary programming language.
- Heaps, Stacks, Priority Queues, and LinkedLists will be utilized for efficient data storage and manipulation.
- Enums will be used to represent fare codes and flyer statuses, with a method to randomly select values.
- Standby list simulation will be performed as described above, including adding and removing passengers based on their priority.

This project aims to demonstrate proficiency in Java data structures, enums, and simulation techniques to manage an airline passenger priority list effectively.
