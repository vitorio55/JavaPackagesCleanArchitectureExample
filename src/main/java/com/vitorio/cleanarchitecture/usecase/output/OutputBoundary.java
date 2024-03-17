package com.vitorio.cleanarchitecture.usecase.output;

import com.vitorio.cleanarchitecture.usecase.output.OutputData;

public interface OutputBoundary {
    void interact(OutputData data);
}
