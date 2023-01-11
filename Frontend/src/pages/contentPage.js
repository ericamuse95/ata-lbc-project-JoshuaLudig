import BaseClass from "../util/baseClass";
import DataStore from "../util/DataStore";
import ContentClient from "../api/ContentClient";

/**
 * Logic needed for the display content page of the website.
 */
class ContentPage extends BaseClass {

    constructor() {
        super();
        this.bindClassMethods(['onGet', 'onCreate', 'renderContent', 'getFavorite','displayAll'], this);
        this.dataStore = new DataStore();
    }

    /**
     * Once the page has loaded, set up the event handlers and fetch the display list for the app contents.
     */
    async mount() {

        document.getElementById('create-content-form').addEventListener('submit', this.onCreate);
        document.getElementById('favorite').addEventListener('click', this.getFavorite);
        document.getElementById('all').addEventListener('click', this.displayAll);
        this.client = new ContentClient();

        this.dataStore.addChangeListener(this.renderContent)
    }

    // Render Methods --------------------------------------------------------------------------------------------------

    async renderContent() {
        let resultArea = document.getElementById("result");

        const content = this.dataStore.get("content");
        console.log(content);

        if (content) {
            resultArea.innerHTML = `
                <div>ID: ${content.artistId}</div>
                <div>Name: ${content.songId}</div>
                <div>Genre: ${content.artistByGenre}</div>
                <div>Year: ${content.artistByYear}</div>
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
    async getFavorite(event) {
            // Prevent the page from refreshing on form submit
            event.preventDefault();
            console.log("getFavorite");

           // let id = document.getElementById("id-field").value;
            this.dataStore.set("content", null);

            let result = await this.client.getFavorites(this.errorHandler);
            this.dataStore.set("content", result);
            if (result) {
                this.showMessage(`Got ${result.name}!`)
            } else {
                this.errorHandler("Error doing GET!  Try again...");
            }
        }
        async displayAll(event) {
                    // Prevent the page from refreshing on form submit
                    event.preventDefault();
                    console.log("displayAll");

                   // let id = document.getElementById("id-field").value;
                    this.dataStore.set("content", null);

                    let result = await this.client.getAllContent(this.errorHandler);
                    this.dataStore.set("content", result);
                    if (result) {
                        this.showMessage(`Got ${result.name}!`)
                    } else {
                        this.errorHandler("Error doing GET!  Try again...");
                    }
                }


    // This works do not change!
    async onCreate(event) {
        // Prevent the page from refreshing on form submit
        event.preventDefault();
        this.dataStore.set("content", null);

        let name = document.getElementById("create-content-SongId").value;
        let artistId = document.getElementById("create-content-Artist").value;
        let artistByGenre = document.getElementById("create-content-Genre").value;
        let artistByYear = document.getElementById("create-content-Year").value;
        const createContent = await this.client.createContent(name, artistId, artistByGenre, artistByYear,this.errorHandler);
        this.dataStore.set("content", createContent);

        if (createContent) {
            this.showMessage(`Create ${createContent.name}!`)
        } else {
            this.errorHandler("Error creating!  Try again...");
        }
        this.renderContent();
    }
}

/**
 * Main method to run when the page contents have loaded.
 */
const main = async () => {
    const contentPage = new ContentPage();
    contentPage.mount();
};

window.addEventListener('DOMContentLoaded', main);
