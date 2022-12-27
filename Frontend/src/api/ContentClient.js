import BaseClass from "../util/baseClass";
import axios from 'axios'

/**
 * Client to call the Music App Service.
 *
 * https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Classes#Mix-ins
 * https://javascript.info/mixins
 */
export default class ContentClient extends BaseClass {

    constructor(props = {}){
        super();
        const methodsToBind = ['ArtistLoaded', 'getContent', 'createContent'];
        this.bindClassMethods(methodsToBind, this);
        this.props = props;
        this.clientLoaded(axios);
    }
    constructor(props = {}){
            super();
            const methodsToBind = ['SongIdLoaded', 'getContent', 'createContent'];
            this.bindClassMethods(methodsToBind, this);
            this.props = props;
            this.clientLoaded(axios);

           constructor(props = {}){
             super();
             const methodsToBind = ['GenreLoaded', 'getContent', 'createContent'];
             this.bindClassMethods(methodsToBind, this);
             this.props = props;
             this.clientLoaded(axios);

             constructor(props = {}){
             super();
             const methodsToBind = ['YearLoaded', 'getContent', 'createContent'];
             this.bindClassMethods(methodsToBind, this);
             this.props = props;
             this.clientLoaded(axios);

    /**
     * Run any data that are supposed to be called once the client has loaded successfully.
     * @param client The client that has been successfully loaded.
     */
    clientLoaded(client) {
        this.client = client;
        if (this.props.hasOwnProperty("onReady")){
            this.props.onReady();
        }
    }

    /**
     * Gets new data for the display in our app.
     * @param errorCallback (Optional) A function to execute a feature if the call fails.
     * @returns The features of the app.
     */
    async getContent(id, errorCallback) {
        try {
            const response = await this.client.get(`/content/${id}`);
            return response.data;
        } catch (error) {
            this.handleError("getContent", error, errorCallback)
        }
    }
    async createContent(name, errorCallback) {
        try {
            const response = await this.client.post(`content`, {
                name: name
            });
            return response.data;
        } catch (error) {
            this.handleError("createContent", error, errorCallback);
          }
        }
        async getAllContent(errorCallback) {
          try{
          const response = await this.client.get(/content/all);
          return response.data;
          }catch (error) {
          this.handleError("getAllContent",error,errorCallback)
            }
          }

    /**
     * Helper method to log the error and run any error features in the app.
     * @param error The error received from the server.
     * @param errorCallback (Optional) A function to execute if the call fails.
     */
    handleError(method, error, errorCallback) {
        console.error(method + " failed - " + error);
        if (error.response.data.message !== undefined) {
            console.error(error.response.data.message);
        }
        if (errorCallback) {
            errorCallback(method + " failed - " + error);
        }
    }
}
