import React from "react";
import { View, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";

export default class AboutUs extends React.Component {
    static navigationOptions = {
        title: "About Us"
    }
    render() {
        return (
            <View style={styles.aboutUs}>
                <Text style={styles.header}>About Us.</Text>
                <Text style={styles.description}>The School of Science and Technology, Singapore (SST) is a Specialised Independent School that offers a distinctive 4-year GCE O-Level programme with an integrated approach to applied learning.</Text>
            </View>
        )
    }
}

var styles = StyleSheet.create({
    aboutUs: {
        flex: 1,
        backgroundColor: "white",
        alignItems: "center",
        paddingLeft: 20,
        paddingRight: 20
    },

    header: {
        color: "black",
        fontSize: 30,
        fontStyle: "italic",
        marginTop: 10,
        marginBottom: 10
    },

    description: {
        color: "black",
        fontSize: 20,
        textAlign: "center",
        marginTop: 10,
        marginBottom: 20
    }
});