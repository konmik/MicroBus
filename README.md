MicroBus
===================

This simple class could be the giant of your application.

It is inspired by OttoBus (http://square.github.io/otto/), and it
has its stronger and weaker points.

Advantages:

1. It does not use annotations.
2. It does not have a bug with subclasses (https://github.com/square/otto/issues/122)
3. It has only 35 lines of code (at the moment of first release).

Disadvantages:

1. This is a one-thread solution.
2. Usage requires a little more code.


USAGE
-------------------

Initialization:

    MicroBus bus = new MicroBus();

Definition of message:

    public class Hello {
        public String name;

        public Hello(String name) {
            this.name = name;
        }
    }

Receiving class:

    class Receiver implements MicroBus.BusEventReceiver {

        public onCreate() {
            bus.register(this, Hello.class);
        }

        public onDestroy() {
            bus.unregister(this, Hello.class);
        }

        @Override
        public void onBusEvent(Object event) {
            if (event instanceof Hello)
                System.out.println("Hello, " + ((Hello)event).name + "!");
        }
    }

Sending:

		    bus.post(new Hello("Joe"));

Output:

	Hello, Joe!


LICENSE
-------------------

http://www.apache.org/licenses/LICENSE-2.0

(c) 2014 Konstantin Mikheev
