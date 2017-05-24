import React from "react";
import { Dimensions, View, Button, Text, StyleSheet } from "react-native";

import LongButton from "../components/LongButton";

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
                <Text style={styles.header}>Welcome.</Text>
                <Text style={styles.description}>To get you started, please input the duration of your stay.</Text>

                <LongButton width={screenWidth} key={1} buttonColor="rgb(189, 188, 189)" text="0 - 1h"/>
                <LongButton width={screenWidth} key={2} buttonColor="rgb(145, 145, 146)" text="1 - 2h"/>
                <LongButton width={screenWidth} key={3} buttonColor="rgb(94, 94, 95)" text="2 - 3h"/>
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