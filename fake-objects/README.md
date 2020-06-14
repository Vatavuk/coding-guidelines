# Fake Objects

Don't use mocking frameworks, use fake objects.

Problems with mocked code:

 - it is hard to reason about
 
 - it can become pretty complex very fast
 
 - its very hard to reuse mocked code

Fake object represents a simple/fake implementation of an interface used to accomodate testing scenarios. 

This project is an example of using fake objects vs mockito.

Use mock framework only when the cost of creating and maintaining a fake object is higher than using the framework.  

#### References
[Built-in Fake Objects](https://www.yegor256.com/2014/09/23/built-in-fake-objects.html)

[Test Doubles - Fakes, Mocks and Stubs](https://blog.pragmatists.com/test-doubles-fakes-mocks-and-stubs-1a7491dfa3da)
