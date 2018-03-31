SONAR system

Components used:
Arduino UNO
Ultrasonic sensor HC-SR04
Servo motor
Jumpwires

What our setup does?

Working principle:
The ultrasonic sensor uses sonar to determine the distance to an object.
the transmitter (trig pin) sends a signal: a high-frequency sound
when the signal finds an object, it is reflected and
the transmitter (echo pin) receives it.
By measuring the time required for the echo to reach to the receiver, we can calculate the distance. 
This is the basic working principle of Ultrasonic module to measure distance.

We need to transmit trigger pulse of at least 10 us to the HC-SR04 Trig Pin.
Then the HC-SR04 automatically sends Eight 40 kHz sound wave and wait for rising edge output at Echo pin.
When the rising edge capture occurs at Echo pin, start the Timer and wait for falling edge on Echo pin.
As soon as the falling edge is captured at the Echo pin, read the count of the Timer.
 This time count is the time required by the sensor to detect an object and return back from an object.
Now how to calculate distance?

We know that,

{Distance = Speed x Time}

The speed of sound waves is 343 m/s.

So,
{Total Distance = 343*Time of high(echo) pulse/2}

Total distance is divided by 2 because signal travels from HC-SR04 to object and returns to the module HC-SR-04.

In our setup:
The servo motor rotates with the ultrasonic sensor atop, the sensor
records the distance of any object within a range of 2cm to 30cm.
The graph is used to compare the estimated distance with the actual distace of the object placed.
The angle of servo motor with the x plane, is used to determine the angle of ultrasonic sensor while calculating the distance on detection
of the object in experimental range.

Factors that affect our result:

As a physical phenomenon, sound is a waveform propagated by the collisions of particles in the medium through which it travels.
 It is little wonder then that the speed of sound should depend mainly on the properties of the medium itself. Some of these properties are:

1.Elastic Modulus (Pressure/Temperature)
But since our testing area was our home only, we didnt notice significant changes in practice.

2.      Density
The speed of sound decreases with an increase in density of the medium and vice-versa.Same here, as our experiment was done only taking medium as air, this didnt effect our readings.
