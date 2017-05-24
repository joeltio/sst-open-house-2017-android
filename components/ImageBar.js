import React from "react";
import { Dimensions, Image, View, Text, StyleSheet } from "react-native";

import resolveAssetSource from 'resolveAssetSource';

var TouchableWithoutFeedback = require('TouchableWithoutFeedback');

export default class ImageBar extends React.Component {
    render() {
        const screenWidth = Dimensions.get("window").width;
        const newHeight = Math.floor((screenWidth) * (this.props.dimen.height/this.props.dimen.width));
        var backgroundImageStyle = {
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            width: screenWidth,
            height: newHeight
        }
        return (
            <TouchableWithoutFeedback onPress={this.props.press}>
                <View style={styles.imageBar}>
                    <Image
                        resizeMode="contain"
                        style={backgroundImageStyle}
                        source={this.props.src}>
                        <Text style={styles.innerText}>{this.props.text}</Text>
                    </Image>
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