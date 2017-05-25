import { StyleSheet } from "react-native";

// Color constants
const colorFontPrimaryDark = "black";

// Style constants
const defaultStyles = StyleSheet.create({
    header: {
        marginTop: 10,
        marginBottom: 10,
        fontSize: 30,
        fontStyle: "italic",
        textAlign: "center",
        color: colorFontPrimaryDark
    },

    description: {
        marginTop: 10,
        marginBottom: 10,
        fontSize: 20,
        textAlign: "center",
        color: colorFontPrimaryDark,
    }
});

export default defaultStyles;