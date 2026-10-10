# Part C — Concept Answers

## 1. String immutability
A `String`'s characters can never change after construction; every "modification"
(`+`, `replace`, …) allocates a brand-new object and abandons the old one. In a
loop this means O(n²) copying and garbage. Mitigate with `StringBuilder`/`StringBuffer`,
which mutate a resizable buffer in place and convert to `String` once at the end.

## 2. `this` resolves shadowing
Inside a constructor, a bare name refers to the parameter, so `name = name` is a
no-op self-assignment. `this.name` explicitly means "this object's field", e.g.
`this.title = title;` copies the parameter into the field. That is why the `Book`
constructor writes `this.title = title; this.price = price;`.

## 3. Object vs reference
An object is the heap data; a reference variable holds that object's address (or
null). `w2 = w1` copies only the address: no new object is created, and both
variables point at the same heap object. Consequently a mutation through `w2`
(e.g. `w2.add(200)`) is visible through `w1`, since there is just one object.

## 4. static vs instance variables
`static` belongs to the class — one copy shared by all instances — ideal for data
common to every object, e.g. `Visitor.visitorCount` tracking total visitors.
Instance variables hold per-object state, e.g. each `Wallet`'s own `balance` or
each `Student`'s `name`; making those static would wrongly share one value.

## 5. for vs while vs do-while
`for` suits counted/bounded iteration (array traversal) since init, condition and
step sit together. `while` suits open-ended conditions checked before each pass
(read input until EOF). `do-while` suits bodies that must run at least once, e.g.
a menu shown before validating the choice. All three are equivalent in power;
the choice documents intent.

## 6. Pass-by-value
Java always passes a copy of the argument. For primitives the copy is the value
itself, so `change(x)` cannot alter the caller's `x`. For objects the copy is the
reference: the method cannot point the caller's variable elsewhere, but it can
mutate the shared object's fields (as `w2.add(200)` mutates the one `Wallet`).

## 7. Integer division
`int / int` discards the fraction (truncates toward zero): `7 / 2 == 3`, and
`total / 3` with ints would give `83`, losing the average. Cast or mix in a
floating operand first — `(double) total / count` — so the division itself runs
in floating point and keeps `83.333…`.

## 8. Encapsulation
Encapsulation hides an object's internals so it can only be used through a
controlled interface. `private` fields (e.g. `Book.title`) block direct outside
access; public getters/setters mediate it, letting the class validate input,
keep invariants (e.g. reject negative prices), and change representation later
without breaking callers.

## 9. `==` vs `equals()`
`==` compares references (same object?), while `equals()` compares content by
contract. The default `Object.equals` behaves like `==`, but classes like
`String` override it to compare characters — hence two distinct `new
String("hello")` objects are `==`-false but `equals`-true. Overriding `equals`
(plus `hashCode`) lets your own classes define value equality the same way.

## 10. Overloading vs overriding
Overloading = same method name, different signatures in one class (e.g. the
three `Student` constructors); the compiler picks the match at compile time
(static polymorphism). Overriding = a subclass redefines an inherited method
with the same signature (e.g. `Card.pay`); the JVM picks the implementation by
the object's runtime type at run time (dynamic dispatch, as in `Payment p = new
Card(); p.pay(500);` printing the card version).
