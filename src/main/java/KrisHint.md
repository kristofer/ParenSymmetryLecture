
## If we have...

#### Trues 

- "()"  -> true
- "( ( ) )" -> true
- "(( (() ) ) )" -> true
- "(zipcode)" -> true

#### Falses

- "(" -> false
- ")" -> false
- "(()" -> false
- "())" -> false

_Some special cases to ponder._

- "" -> false
- "zipcode" -> false
- ")(" -> false

### Some more longer cases

_Trues_

- "(((((((((())))))))))" -> true
- "(())()()()()((()))()()()" -> true
- "((( () () () )))" -> true

_Falses_

- ")((((((((())))))))))" -> false
- "(())()()()()(()))()()()" -> false
- "((( () ( () )))" -> false

```
// STEP ZERO
// get the obvious stuff out of the way
//
// We know we will HAVE TO PROCESS each CHARACTER in
// the input STRING s.
// c is a single char from s
//
func is-balanced1(s) {

    for each c in string-s
        if '(' == c, processParen()
        if ')' == c, processThesis()

    if the-string-is-balanced return true
    // else
    return false
}
// NOW, what ideas for processParen() and processThesis() ??
```


```
// count ( and ) and look for equal number
// ")(" -> false
// "" -> false
func is-balanced1(s) {
    parens = 0
    thesis = 0

    for each c in string-s
        if '(' == c, parens++
        if ')' == c, thesis++

    if parens == thesis return true
    else return false
}

// but what's the problem? ==> ")(" is false (but it would say true)
// also "" ==> true (but it's not)
```

## What other possibilities?

```
// also, Does the solution IGNORE anything other that Paren and Thesis?
s = "()foo()bar"

yeah, it kinda does
```

_What is **always** true about any balanced case?_

_What is **always** true about any UNBALANCED case?_

_Balanced cases: # of Parens EQUALS # of Thesis._

_UNBalanced cases: # of Parens DOES NOT EQUAL # of Thesis._

```
// track and count ( and ) separately and look for equal number
// what about ")(" ?? 
//
// Hmm: well, what if _thesis_ is EVER greater that _parens_...
// means "( ) )" is false (parens == 1, thesis == 2)
// means "( ( )" is false (parens == 2, thesis == 1)
//
func is-balanced2(s) {
    parens = 0
    thesis = 0

    for each c in string-s
        if '(' == c, parens++
        if ')' == c, thesis++
        if thesis > parens return false

    if parens == thesis return true
    else return false
}

// now at least we'd catch ")(" but not "" (empty string)
```

```
// count ( and ) and look for equal number
func is-balanced2(s) {

    if s == "" return false // what's known as a
                            // "short-circuit" case

    // in java, it's best to...
    if s.isEmpty() return false 

    parens = 0
    thesis = 0

    for each c in string-s
        if '(' == c, parens++
        if ')' == c, thesis++
        if thesis > parens return false

    if parens == thesis return true
    
    return false
}
```

**Now, take this code and _en-java-ify_ it and run the tests.**

```
// an alternative is to just add up the parens, and subtract the thesis
// if empty string, false
//    if negative, false (inside)
// if positive, false
// if zero, true
```

## And for the file stuff.

```java
//parensymmetry help

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLineUsingBufferedReader {

	public static void main(String[] args) {
		BufferedReader reader;

		try {
			reader = new BufferedReader(new FileReader("sample.txt"));
			String line = reader.readLine();

			while (line != null) {
				System.out.println(line); // process it somehow using isBalanced
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
```

