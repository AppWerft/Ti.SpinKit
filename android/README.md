Ti.SpinKit
==========

This is the Titanium version of [Spinkit](https://github.com/ybq/Android-SpinKit). Thanks to Yang Bing Qaing

![](https://raw.githubusercontent.com/ybq/AndroidSpinKit/master/art/screen.gif)

Usage
-----

~~~
var SKV = require('ti.appwerft.spinkit');

var spinkitView = SKV.createSpinnerView({
    type : SKV.TYPE_ROTATINGPLANE,
    color : '#ffffff',
});
~~~

Available types:

TYPE_ROTATINGPLANE, TYPE_DOUBLEBOUNCE, TYPE_WAVE, TYPE_WANDERINGCUBES, TYPE_PULSE, TYPE_CHASINGDOTS, TYPE_THREEBOUNCE, TYPE_CIRCLE, TYPE_CUBEGRID, TYPE_FADINGCIRCLE, TYPE_FOLDINGCUBE, TYPE_ROTATINGCIRCLE.