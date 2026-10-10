# Assignment 09 — Category C Coding Assignment (OOP Design)

5 problems. Each is a standalone Java program (`Main.java`): compile with
`javac Main.java`, run with `java Main`, feeding the described input on stdin.

| # | Problem | Folder | OOP concept demonstrated |
|---|---|---|---|
| 1 | Movie Ticket Counter | [`problem-01-movie-ticket/`](./problem-01-movie-ticket/) | Abstract class (`Ticket` owns count + single convenience fee; plain ticket impossible) |
| 2 | Parcel Shipping Desk | [`problem-02-parcel-shipping/`](./problem-02-parcel-shipping/) | Abstract class + segregated interface (`Insurable` only on Express/Fragile; Fragile reuses Standard charge) |
| 3 | College Fee Counter | [`problem-03-college-fee/`](./problem-03-college-fee/) | Abstract class + capability interface (`BusUser` holds the one transport fee; counter checks the ability, not the type) |
| 4 | City Cab Fare Meter | [`problem-04-cab-fare/`](./problem-04-cab-fare/) | Template method + capability interface (shared minimum-fare rule in base; `NightService` only on Sedan/SUV) |
| 5 | Home Appliance Energy Report | [`problem-05-appliance-energy/`](./problem-05-appliance-energy/) | Abstract class + capability interface (shared units/cost formula; `SaverCapable` only on AC/Washer) |

Recurring design rule: what **every** variant shares goes in the abstract base
**once**; what only **some** variants can do goes in an **interface**, detected
with `instanceof` — never an if-else chain on type names.
