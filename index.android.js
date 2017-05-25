"use strict";

import React from "react";
import { AppRegistry, StyleSheet } from "react-native";

import { StackNavigator } from 'react-navigation';

import Home from "./pages/Home";
import GettingStarted from "./pages/GettingStarted";
import AboutUs from "./pages/AboutUs";
import Recommended from "./pages/Recommended";

import ActivityInfo from "./pages/ActivityInfo";

const App = StackNavigator({
    Home: {screen: Home},
    GettingStarted: {screen: GettingStarted},
    AboutUs: {screen: AboutUs},
    Recommended: {screen: Recommended},
    
    // Activities
    ActivityInfo: {screen: ActivityInfo}
});

AppRegistry.registerComponent("MainPage", () => App);