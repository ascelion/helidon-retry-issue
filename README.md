# Fault Tolerance doesn't work for Rest Client

## Environment Details
* Helidon Version: 1.3.1
* Helidon MP
* JDK version: any
* OS: any

----------

## Problem Description
The __Microprofile Rest Client__ specification [states](https://download.eclipse.org/microprofile/microprofile-rest-client-1.3.3/microprofile-rest-client-1.3.3.html#_microprofile_fault_tolerance):

> MP Rest Client implementations must ensure that MP Fault Tolerance annotations on client interfaces are honored. In general, these annotations are treated as CDI interceptor bindings.

Such interfaces in Helidon don't work because the fault tolerance module throws a NPE. The `CommandRetrier` attempts to update the fault tolerance metrics but the associated counters are not registered.

The reason is that `FaultToleranceExtension` which is responsible with the registration of these counters, @Observes only `ProcessManagedBean<?>` events, while the beans created by `RestClientExtension` are synthetic.

## Steps to reproduce

Run:

	git clone https://github.com/pa314159/helidon-retry-issue
	./gradlew run

... then in a new terminal run:

	curl -i http://localhost:7001

... and check the outputs in both terminals.

