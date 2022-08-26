public class DeleteCommand extends Command {
    private int index;

    public DeleteCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        Task removedTask = tasks.removeTask(index);
        ui.showRemoveTask(removedTask);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

