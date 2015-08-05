MicroBus - DEPRECATED
===================

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-MicroBus-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/1380)

The event bus is considered to be an anti-pattern now.
Thus, I mark it as deprecated now.

Code that relies heavily on using a bus is an unsupportable mess.
Use Observable-Observer patters instead, [RxJava](https://github.com/ReactiveX/RxJava) preferable.

USAGE
-------------------

Initialization:

    MicroBus bus = new MicroBus();

Definition of a message:

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
