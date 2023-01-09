import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import ContentClient from "../api/ContentClient";

/**
 * Logic needed for the display content page of the website.
 */
class contentPage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onGetContents', 'onCreate', 'renderContent'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the display list for the app contents.
     */
    async mount() {

        document.getElementById('create-content-form').addContent('submit', this.onCreate);
        this.client = new ContentClient();

        this.dataStore.addContent(this.renderContent)
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderContent() {
        let resultArea = document.getElementById("Artist-info");

        const content = this.dataStore.get("Artist");

        if (content) {
            resultArea.innerHTML = `
                <div>ID: ${content.id}</div>
                <div>Name: ${content.name}</div>
            `
        } else {
            resultArea.innerHTML = "No Item";
        }
    }

    // Event Handlers --------------------------------------------------------------------------------------------------

    async onGet(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();

        let id = document.getElementById("id-field").value;
        this.dataStore.set("content", null);

        let result = await this.client.getContent(id, this.errorHandler);
        this.dataStore.set("content", result);
        if (result) {
            this.showMessage(`Got ${result.name}!`)
        } else {
            this.errorHandler("Error doing GET!  Try again...");
        }
    }

    async onCreate() {
        // Prevent the page from refreshing on form submit
        event.preventDefault();
        this.dataStore.set("content", null);

        let name = document.getElementById("create-name-field").value;

        const createdContent = await this.client.createContent(name, this.errorHandler);
        this.dataStore.set("content", createdContent);

        if (createdContent) {
            this.showMessage(`Created ${createdContent.name}!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const contentPage = new ContentPage();
    contentPage.mount();
};

//window.addContent('ContentLoaded', main);
