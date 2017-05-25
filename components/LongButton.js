import React from "react";
import { Dimensions, Image, View, Text, StyleSheet } from "react-native";

import resolveAssetSource from 'resolveAssetSource';

var TouchableWithoutFeedback = require('TouchableWithoutFeedback');

export default class LongButton extends React.Component {
    render() {
        const buttonStyle = {
            backgroundColor: this.props.buttonColor,
            alignItems: "center",
            width: this.props.width,
            paddingTop: 20,
            paddingBottom: 20
        }

        const textStyle = {
            color: "black",
            fontSize: 40
        }
        return (
            <TouchableWithoutFeedback onPress={this.props.onPress}>
                <View style={buttonStyle}>
                    <Text style={textStyle}>{this.props.text}</Text>
                </View>
            </TouchableWithoutFeedback>
        );
    }
}