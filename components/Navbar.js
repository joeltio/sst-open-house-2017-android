import React from "react";
import { View, Image, StyleSheet } from "react-native";

export default class Navbar extends React.Component {
    render() {
        return (
            <View style={styles.navbar}>
                <Image
                    style={styles.icon}
                    source={require("../resources/img/sst_logo.jpg")}
                />
            </View>
        );
    }
}

var styles = StyleSheet.create({
    icon: {
        height: 50,
        width: 50
    },

    navbar: {
        flexDirection: "row",
        justifyContent: "center",
        backgroundColor: "white"
    }
});