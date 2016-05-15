/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 * Warning: This file is GENERATED, and should not be modified
 */
var bootstrap = kroll.NativeModule.require("bootstrap"),
	invoker = kroll.NativeModule.require("invoker"),
	Titanium = kroll.binding("Titanium").Titanium;

function moduleBootstrap(moduleBinding) {
	function lazyGet(object, binding, name, namespace) {
		return bootstrap.lazyGet(object, binding,
			name, namespace, moduleBinding.getBinding);
	}

	var module = moduleBinding.getBinding("de.appwerft.spinkit.SpinModule")["Spin"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "Spin";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "Spin", "Spin", "createExample");
	addInvocationAPI(module, "Spin", "Spin", "createSpinKitView");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"SpinKit": {
				get: function() {
					var SpinKit = lazyGet(this, "de.appwerft.spinkit.SpinKitModule", "SpinKit", "SpinKit");
					return SpinKit;
				},
				configurable: true
			},
			"SpinKitView": {
				get: function() {
					var SpinKitView = lazyGet(this, "de.appwerft.spinkit.SpinKitViewProxy", "SpinKitView", "SpinKitView");
					return SpinKitView;
				},
				configurable: true
			},
			"Example": {
				get: function() {
					var Example = lazyGet(this, "de.appwerft.spinkit.ExampleProxy", "Example", "Example");
					return Example;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createExample = function() {
			return new module.Example(arguments);
		}
		module.constructor.prototype.createSpinKitView = function() {
			return new module.SpinKitView(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
