# Part B — Quiz Answers

| Q | Answer | Why |
|---|---|---|
| 1 | D | `new` creates two distinct heap objects (`==` false); same content so `equals` true |
| 2 | B | Content is `Java Lab`; `reverse()` flips it to `baL avaJ` |
| 3 | B | Overload resolution picks `Student(String)` directly; it then chains to the 2-arg one |
| 4 | D | `w2 = w1` copies the reference — one object, so both see 700 |
| 5 | C | `static count` is shared; 3 constructions → 3 |
| 6 | A | Plain 0→length-1 traversal prints every element in order |
| 7 | B | `continue` skips only i==3 → `1 2 4 5` |
| 8 | A | Java is pass-by-value: `change(x)` mutates only the copy, x stays 5 |
| 9 | C | `int/double` promotes to double: 250/3.0 = 83.33333333333333 |
| 10 | B | Dynamic dispatch runs `Card.pay`: 500 + 2% = 510.0 |
| 11 | B | Strings are immutable: `name` stays `java`, new `JAVA` object for `upperName` |
| 12 | B | One pooled `"hello"` shared by s1/s2 + one heap object from `new String` |
| 13 | A | Length 6; index 2 of `Campus` is `m` |
| 14 | A | `u(0)s(1)e(2)r(3)@(4)` → 4 |
| 15 | B | Default constructor sets `Unknown` / 0.0 |
| 16 | A | Parameterized constructor assigns both fields via `this` |
| 17 | B | `w2 = w1` is an alias (no new object); `w3` is the second object |
| 18 | C | One shared object mutated through w2 → both read 700 |
| 19 | C | s1 and s2 are independent objects; only s1 changes |
| 20 | C | Shared static counter incremented 3 times → `Total visitors: 3` |
