import React from "react";
import { Dimensions, Image } from "react-native";

import TouchableWithoutFeedback from 'TouchableWithoutFeedback';

export default class FitImage extends React.Component {
    constructor(props) {
        super(props);
        this.imageHeight = props.image.height;
        this.imageWidth = props.image.width;
        this.imageSource = props.image.source;
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
            <Image
                source={this.imageSource}
                resizeMode="stretch"
                style={backgroundImageStyle}>
                {this.props.children}
            </Image>
        );
    }
}