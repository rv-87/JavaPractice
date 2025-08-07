In this Package I have practiced 50+ stream questions.

## Few of most used Stream function and its brief description are:-
* stream() -> convert a collections into stream

* filter() -> filter based on predicate
* map()-> transform each element into another form and returns a new stream.
* flatMap() -> it flattens a nested structure into a single stream
* forEach -> Perform action in each element, Iterate all the elements of stream.
* collect() -> collects elements into collection.
* sorted() -> sorts the elements into natural order. In one of its argument it accept Comparator.comparing(String::length), Using this comparator we can specify which property to use to sort any custom object.
* limit() -> limits the number of element from the stream.
* distinct() -> return all unique element from a stream.Removes duplicate and returns a stream.
* skip() -> .skip(n) -> then it skips first n elements of stream and returns a stream
* peek() -> allow inspection of each element os stream.
* count() -> return the number of elements in stream, Its Terminal operation
* allMatch() -> returns true if all elements match the predicate
* anyMatch() -> returns true if any elements matchs the predicate
* noneMatc() -> returns true if no elements matchs the predicate
* findFirst() -> return first elements of the Stream. Terminal operation
* findAny() -> returns any elements of the stream. terminal Operation.
* max() -> find maximum elements from the stream.Terminal Operation.It takes a comparator as input.
* min() -> find minimun elements from the stream.Terminal Operation.It takes a comparator as input.
* toArray() -> convert stream to array.
* generate() ->  create an infinite stream of elements.(Ex - Stream<Double> ssd = Stream.generate(Math::randon))
* iterate() -> create infinite stream by iteration over function(Ex: Stream<Integer> num = Stream.iterate(0,n->n+2).limit(10))
* of() -> creates a stream from a set of values,(Ex: Stream.of("Hello","Bye","Tata"))
* concat() -> concat two streams
* reduce() -> reduces stream into a single element. 