"use strict";

import React from "react";
import { Dimensions, Text, AppRegistry, StyleSheet, View, ScrollView } from "react-native";

import { StackNavigator } from "react-navigation";

import Home from "./pages/Home";
import GettingStarted from "./pages/GettingStarted";
import AboutUs from "./pages/AboutUs";

const App = StackNavigator({
    Home: {screen: Home},
    GettingStarted: {screen: GettingStarted},
    AboutUs: {screen: AboutUs}
});

AppRegistry.registerComponent("MainPage", () => App);
