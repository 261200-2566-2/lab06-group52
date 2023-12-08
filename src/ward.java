public class ward implements accessories{

    /* Obtains a specific statistic of ward for a Human character.
     *
     * @param a  Human character for which the statistic is obtained.
     * @return The specific statistic value of ward for the Human character when equipped.
     */
    @Override
    public double getstat(human a){
        double stat=10;
        return stat;
    }

    /* Obtains a specific statistic of ward for an Undead character.
     *
     * @param an Undead character for which the statistic is obtained.
     * @return The specific statistic value of ward for the Undead character when equipped.
     */
    @Override
    public double getstat(undead a){
        double stat=20;
        return stat;
    }

}//เป็นfunctionที่มีinputเป็นobject class humanและundead มีoutputเป็นค่าของstatที่เปลี่ยนแปลง เอาไว้เรียกใช้ตอนequip โดยหากใส่wardให้undeaadจะได้รับmanaที่มากกว่าใส่ให้human

