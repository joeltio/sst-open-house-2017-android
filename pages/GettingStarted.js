import React from "react";
import { Dimensions, View, Button, Text, StyleSheet } from "react-native";

import LongButton from "../components/LongButton";
import defaultStyles from "../stores/styleStore";

var screenWidth
export default class GettingStarted extends React.Component {
    static navigationOptions = {
        title: "Getting Started"
    }
    render() {
        const { navigate } = this.props.navigation;
        const screenWidth = Dimensions.get("window").width;

        const durations = [
            ["0 - 1h", "rgb(189, 188, 189)"],
            ["1 - 2h", "rgb(145, 145, 146)"],
            ["2 - 3h", "rgb(94, 94, 95)"]
        ].map((e, i) => <LongButton key={i} width={screenWidth} text={e[0]} buttonColor={e[1]} />)

        return (
            <View style={styles.gettingStarted}>
                <Text style={defaultStyles.header}>Welcome.</Text>
                <Text style={defaultStyles.description}>To get you started, please input the duration of your stay.</Text>

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