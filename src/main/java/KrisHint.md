
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
s = "()foo()bar"
remove nondelimiter => "()()"
```

```
// count ( and ) and look for equal number
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

// now at least we'd catch ")(" but not ""
```

```
// count ( and ) and look for equal number
func is-balanced2(s) {

    if s == "" return false // what's known as a
                            // "short-circuit" case
    if s.isEmpty() return false // what's known as a
                            // "short-circuit" case

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

