# List ADT — Practice: SparseList

A third implementation of the `List` ADT: `SparseList` stores only the positions whose value differs from a chosen default, as a chain of `(index, value)` nodes kept sorted by index.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      listadt/
        List.java           # the chapter's List<T> contract, vendored here so this problem's code runs standalone
      practice/
        SparseList.java     # a third List implementation, storing only non-defaults
        PracticeMain.java   # the SparseList demo
  scripts/
    run.sh                  # compile everything and run the practice demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs the practice demo (`practice.PracticeMain`).

There is no build tool and no test suite: testing is introduced later in the course. The script above is all you need.

## What's here

- `practice.SparseList<T>` — implements `List<T>` by storing only the positions whose value differs from a default, as a chain of `(index, value)` nodes led by a front sentinel and kept sorted by index. `get` and `set` walk the chain to the position; `add` appends at the next index and stores nothing when the value is the default, which is where the space savings come from. Same contract as `ArrayList` and `LinkedList`; very different representation and cost.
- `practice.PracticeMain` — builds a mostly-default `SparseList`, then exercises `add`, `get`, and `set`.
- `listadt.List<T>` — the chapter's documented `List` contract. Vendored here unchanged (same package, same content) so this problem's code has no dependency on the lecture-notes sibling and compiles and runs on its own. It is an unchanged copy of `cs226fa26/0800-list-adt/code/src/main/listadt/List.java`, kept in sync only by re-vendoring, not by import.
