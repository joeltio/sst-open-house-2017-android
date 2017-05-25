import React from "react";
import { View, Text, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";
import defaultStyles from "../stores/styleStore";

export default class AboutUs extends React.Component {
    static navigationOptions = {
        title: "About Us"
    }
    render() {
        return (
            <View style={styles.aboutUs}>
                <Text style={defaultStyles.header}>About Us.</Text>
                <Text style={defaultStyles.description}>The School of Science and Technology, Singapore (SST) is a Specialised Independent School that offers a distinctive 4-year GCE O-Level programme with an integrated approach to applied learning.</Text>
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