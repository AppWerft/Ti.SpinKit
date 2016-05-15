Ti.SpinKit
==========

This is the android version of [Spinkit](https://github.com/ybq/Android-SpinKit). 

![](https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/screen.gif)

Usage
-----

~~~
var SKV = require('ti.appwerft.spinkit');

var spinkitView = SKV.createSpinKitView({
    type : SKV.TYPE_ROTATINGPLANE,
    color : '#ffffff',
    width:100,
    height:100
});
~~~

Possible types:

TYPE_ROTATINGPLANE, TYPE_DOUBLEBOUNCE, TYPE_WAVE, TYPE_WANDERINGCUBES, TYPE_PULSE, TYPE_CHASINGDOTS, TYPE_THREEBOUNCE, TYPE_CIRCLE, TYPE_CUBEGRID, TYPE_FADINGCIRCLE, TYPE_FOLDINGCUBE, TYPE_ROTATINGCIRCLE.