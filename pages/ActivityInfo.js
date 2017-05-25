import React from "react";
import { ScrollView, Text, Image, StyleSheet } from "react-native";

import ImageBar from "../components/ImageBar";
import FitImage from "../components/FitImage";

import defaultStyles from "../stores/styleStore";

export default class ActivityInfo extends React.Component {
    constructor(props) {
        super(props);
        this.imageBar = props.navigation.state.params.imageBar;
        this.description = props.navigation.state.params.description;
        this.location = props.navigation.state.params.location;
        this.locationImage = props.navigation.state.params.locationImage;
    }

    render() {
        console.log(this.props);
        return (
            <ScrollView style={styles.activityInfo}>
                {this.imageBar}
                <Text style={defaultStyles.description}>{this.description}</Text>
                <Text style={styles.location}>{this.location}</Text>
                <FitImage image={this.locationImage} />
            </ScrollView>
        );
    }
}

var styles = StyleSheet.create({
    activityInfo: {
        flex: 1,
        backgroundColor: "white",
    },
    location: {
        textAlign: "center",
        color: "black",
        fontSize: 40
    }
});