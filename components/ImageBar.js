import React from "react";
import { Dimensions, Image, View, Text, StyleSheet } from "react-native";

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
        const aspectRatio = this.imageHeight/this.imageWidth;

        const newWidth = Dimensions.get("window").width;
        const newHeight = Math.floor(newWidth * aspectRatio);
        
        var backgroundImageStyle = {
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
            width: newWidth,
            height: newHeight
        }
        return (
            <TouchableWithoutFeedback onPress={this.props.onPress}>
                <View style={styles.imageBar}>
                    <Image
                        source={this.imageSource}
                        resizeMode="contain"
                        style={backgroundImageStyle}>
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