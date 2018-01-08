# RootAssignment

## Approach
Simple approach following KISS, SOLID and YAGNI
- object modeling / software design
- testing approach
- thought process

Uncle bob's three rules of TDD

1. You are not allowed to write any production code unless it is to make a failing unit test pass.
2. You are not allowed to write any more of a unit test than is sufficient to fail; and compilation failures are failures.
3. You are not allowed to write any more production code than is sufficient to pass the one failing unit test.

My approach 

1. Started with writing a failing test
2. Fix the unit test by writing production code
3. Not writing more code


## Libraries used
Joda for date manipulation

## Project Structure
- Source  RootAssignmentOne/src/main/java
- Main Class RootAssignmentOne/src/main/java/com/rj/root/assignment/Console
- Exception RootAssignmentOne/src/main/java/com/rj/root/assignment/exceptions
- Model RootAssignmentOne/src/main/java/com/rj/root/assignment/model
- Util RootAssignmentOne/src/main/java/com/rj/root/assignment/utils
- Tests RootAssignmentOne/src/test/java/com/rj/root/assignment

## How to execute
java Console pathToFile
