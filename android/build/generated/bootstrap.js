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

	var module = moduleBinding.getBinding("de.appwerft.spinkit.SpinKitModule")["SpinKit"];
	var invocationAPIs = module.invocationAPIs = [];
	module.apiName = "SpinKit";

	function addInvocationAPI(module, moduleNamespace, namespace, api) {
		invocationAPIs.push({ namespace: namespace, api: api });
	}

		addInvocationAPI(module, "SpinKit", "SpinKit", "createSpinnerView");

			if (!("__propertiesDefined__" in module)) {		
		Object.defineProperties(module, {
			"SpinnerView": {
				get: function() {
					var SpinnerView = lazyGet(this, "de.appwerft.spinkit.SpinnerViewProxy", "SpinnerView", "SpinnerView");
					return SpinnerView;
				},
				configurable: true
			},
		
		});
		module.constructor.prototype.createSpinnerView = function() {
			return new module.SpinnerView(arguments);
		}
		}
		module.__propertiesDefined__ = true;
		return module;

}
exports.bootstrap = moduleBootstrap;
