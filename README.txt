At the moment you must have a "dictonary.txt" file that contains a plaintext line-by-line dictionary. The one I used for testing can be found here:
https://github.com/dmcguinness/Hangman/blob/master/dictionary.txt#L2

Currently the program will reject your letter input if the letter was FOUND, or if your input is more than one letter. Re-inputting a non-found letter will count against you. 

Things I will try to add/improve upon: 

- Error when user enters only white space 
- "Hard" mode, which requires you to guess a letter within x seconds or you will get another "hangman" tally against you. 
- ASCII hangman instead of tally. 