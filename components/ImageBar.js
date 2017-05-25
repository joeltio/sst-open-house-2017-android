import React from "react";
import { Dimensions, Image, View, Text, StyleSheet } from "react-native";

import FitImage from "./FitImage";

import TouchableWithoutFeedback from 'TouchableWithoutFeedback';

import resolveAssetSource from 'resolveAssetSource';

/* ImageBar
 * Props:
 *  - text
 *    The text to display inside the ImageBar
 *
 *  - image
 *    An object with the properties height, width and the source
 *    e.g. { height: 50, width: 50, source: require('image.jpg') }
 *
 *  - onPress
 *    Function for what to do when the ImageBar is pressed
 */
export default class ImageBar extends React.Component {
    constructor(props) {
        super(props);
        this.imageHeight = props.image.height;
        this.imageWidth = props.image.width;
        this.imageSource = props.image.source;
        this.text = props.text;
    }

    render() {
        return (
            <TouchableWithoutFeedback onPress={this.props.onPress}>
                <View style={styles.imageBar}>
                    <FitImage image={this.props.image}>
                        <Text style={styles.innerText}>{this.props.text}</Text>
                    </FitImage>
                </View>
            </TouchableWithoutFeedback>
        );
    }
}

var styles = StyleSheet.create({
    innerText: {
        fontSize: 40,
        color: "white"
    },

    imageBar: {
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center"
    }
});