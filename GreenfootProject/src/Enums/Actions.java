package Enums;

import GreenfootNetworking.NetworkedActor;
import GreenfootNetworking.NetworkedWorld;

/**
 * @see #HANDSHAKE
 * @see #UPDATE_POSITION
 * @see #UPDATE_ROTATION
 * @see #UPDATE_IMAGE
 * @see #ADD_ACTOR
 * @see #CREATE_ACTOR
 * @see #REMOVE_ACTOR
 * @see #ADD_WORLD
 * @see #UPDATE_ACTOR_ID
 * @see #REQUEST_OTHER_ACTORS
 */
public enum Actions {
    /**
     * Parameters used Upstream:
     * {@link Parameters#ClientId} int <br>
     * Parameters used Downstream:
     * {@link Parameters#ClientId} int <br>
     * {@link Parameters#AllCurrentActors} String <br>
     * Sent Downstream to inform a client that a TCP connection has been established successfully, Triggers an Upstream Handshake message over UDP
     * Sent Upstream to identify the UDP connection of a client to a server
     */
    HANDSHAKE,
    /**
     * Parameters used Upstream & Downstream:
     * {@link Parameters#ClientId}, int, defines the client sending the message <br>
     * {@link Parameters#ActorId}, int, defines the actor id receiving position update <br>
     * {@link Parameters#NewXPosition}, int, defines the New XPosition of the actor <br>
     * {@link Parameters#NewYPosition}, int, defines the New YPosition of the actor <br>
     * Sent Upstream to inform the server about a position about of a certain actor
     * Informed Downstream to update the position on all other clients except the client who sent the message in the first place
     */
    UPDATE_POSITION,
    /**
     * Parameters used Upstream & Downstream:
     * {@link Parameters#ClientId}, int, defines the client sending the message <br>
     * {@link Parameters#ActorId}, int, defines the actor receiving the rotation update <br>
     * {@link Parameters#NewRotation}, int, defines the new Rotation of the client <br>
     * Sent Upstream to inform the server about a new rotation of a certain actor
     */
    UPDATE_ROTATION,
    /**
     * Parameters used Upstream & Downstream:
     * {@link Parameters#ClientId}, int, defines the client sending the message <br>
     * {@link Parameters#ActorId}, int, defines the actor receiving the image update <br>
     * {@link Parameters#NewImageFilePath}, String <br>
     * Sent if an image got updated
     */
    UPDATE_IMAGE,
    /**
     * Parameters used Upstream & Downstream:
     * {@link Parameters#ActorId}, int, defines the actor that gets added to the world <br>
     * {@link Parameters#WorldId}, int, defines the world the actor should be added to <br>
     * {@link Parameters#NewXPosition}, int, defines the XPosition the actor should be initially placed on, only if already in world <br>
     * {@link Parameters#NewYPosition}, int, defines the YPosition the actor should be initially placed on, only if already in world <br>
     * {@link Parameters#NewImageFilePath}, String, defines the Path to the image the actor should initially have <br>
     * Sent from the world as soon as {@link NetworkedWorld#addNetworkObject(NetworkedActor, int, int)} is called
     */
    ADD_ACTOR,
    /**
     * Parameters used Upstream & Downstream
     * {@link Parameters#NewActorInformation}, JObject, defines the information of the newly created actor {@link NetworkedActor#toJsonString()} <br>
     * {@link Parameters#ActorId}, int, defines the id of the actor being created
     * {@link Parameters#WorldId}, int, defines the world an actor is in (-1 if in no world)
     * {@link Parameters#NewImageFilePath}, String, The image path (if already set)
     * {@link Parameters#NewXPosition}, int, The XPosition of the actor in the world if worldId > -1
     * {@link Parameters#NewYPosition}, int, The YPosition of the actor in the world if worldId > -1
     * {@link Parameters#ClientId}, int, defines the client sending the message
     */
    CREATE_ACTOR,
    /**
     *
     */
    REMOVE_ACTOR,
    /**
     *
     */
    ADD_WORLD,
    /**
     *
     */
    UPDATE_ACTOR_ID,
    /**
     * 
     */
    REQUEST_OTHER_ACTORS
}
