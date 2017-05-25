import React from "react";
import { View, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";

import defaultStyles from "../stores/styleStore";
import strings from "../stores/aboutUsStore"

export default class AboutUs extends React.Component {
    static navigationOptions = {
        title: "About Us"
    }
    render() {
        return (
            <View style={styles.aboutUs}>
                <Text style={defaultStyles.header}>{strings.header}</Text>
                <Text style={defaultStyles.description}>{strings.description}</Text>
            </View>
        )
    }
}

var styles = StyleSheet.create({
    aboutUs: {
        flex: 1,
        paddingLeft: 20,
        paddingRight: 20,
        paddingTop: 20,
        backgroundColor: "white",
        alignItems: "center"
    }
});