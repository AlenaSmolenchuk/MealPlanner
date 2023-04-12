# MealPlanner
This app will also help create and store shopping lists based on the meals so that no ingredient is missing.

# Stage 1/6: Add meals

Your program should:

Ask about the meal category with the following message: Which meal do you want to add (breakfast, lunch, dinner)?;
Ask about the name of the meal with the message Input the meal's name:;
Inquire about the necessary ingredients with the message Input the ingredients:. The input contains ingredients in one line separated by commas. The output displays each ingredient on a new line (see Examples);
Print all the information about the meal in the following format:

Category: category
Name: meal's name
Ingredients:
ingredient 1
ingredient 2
ingredient 3

Print the message that the meal is saved successfully: The meal has been added!.

# Stage 2/6: Create a menu (in process)

To complete this stage, the program must comply with the following requirements:

1. Create an infinite loop of your program that can be terminated with the exit command only;
2. Prompt users to choose an operation with the message What would you like to do (add, show, exit)?
3. After the command has been processed, ask for another operation;
4. Make sure that the input and output formats are correct;
5. If users want to add a meal, follow the sequence from the previous stage. Don't forget to validate input as explained above. Output The meal has been added! before proceeding;
6. If users want to show the meals when no meals have been added, print No meals saved. Add a meal first. If there are meals that can be dislayed, print them in the order they've been added, following the format from Stage 1;
7. Print Bye! and end the program once the exit command is entered;
8. If users fail to input a valid command, print the following message again: What would you like to do (add, show, exit)?
