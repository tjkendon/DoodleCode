# List Difference Finder

Suppose you have two lists of names and you want to know how similar they are, or who's only one one, or who's on both. Well this the a tool to do that.

Mostly designed to allow me to imperically tell sports casters that none of the players on today's world cup squads also played in 1950, but also useful for other organization tasks.

Command line only at this point. Other versions forthcoming some day.

## Usage

usage: ldt <options> fileA fileB
 -a,--showA              show the elements in a
 -A,--uniqueA            show the unique elements in A
 -b,--showB              show the elements in b
 -B,--uniqueB            show the unique elements in B
 -h,--help               show this help message
 -i,--showIntersection   show the elements in the intersection
 -j,--showJaccard        show the Jaccard similarity between A and B
 -o,--showO              show the Szymkiewicz–Simpson similarity between A
                         and B
 -p,--percentA           show the percentage of unique elements in A
 -q,--percentB           show the percentage of unique elements in B
 -s,--showSD             show the Soerensen-Dice similarity between A and
                         B
 -u,--showUnion          show the elements in the union

## Dependencies

- [Apache Commons CLI](https://commons.apache.org/proper/commons-cli/usage.html)

