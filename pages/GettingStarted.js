import React from "react";
import { Dimensions, View, Button, Text, StyleSheet } from "react-native";

import LongButton from "../components/LongButton";

import defaultStyles from "../stores/styleStore";
import { strings, colors } from "../stores/gettingStartedStore";

var screenWidth
export default class GettingStarted extends React.Component {
    static navigationOptions = {
        title: "Getting Started"
    }
    render() {
        const { navigate } = this.props.navigation;
        const screenWidth = Dimensions.get("window").width;

        const durations = [
            [strings.shortDuration, colors.shortDuration],
            [strings.mediumDuration, colors.mediumDuration],
            [strings.longDuration, colors.longDuration]
        ].map((e, i) => <LongButton key={i} width={screenWidth} text={e[0]} buttonColor={e[1]} />)

        return (
            <View style={styles.gettingStarted}>
                <Text style={defaultStyles.header}>{strings.header}</Text>
                <Text style={defaultStyles.description}>{strings.description}</Text>

                <View style={styles.durations}>
                    {durations}
                </View>
            </View>
        )
    }
}

var styles = StyleSheet.create({
    gettingStarted: {
        flex: 1,
        backgroundColor: "white",
        alignItems: "center"
    },

    durations: {
        marginTop: 10
    }
});